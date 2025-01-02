package kr.sfox.alpha.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.sfox.alpha.domain.Post;
import kr.sfox.alpha.repository.PostRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Transactional
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    @Transactional
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Transactional
    public Post updatePost(Long id, Post post) {
        Post postToUpdate = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        postToUpdate.setTitle(post.getTitle());
        postToUpdate.setContent(post.getContent());
        postToUpdate.setAuthor(post.getAuthor());

        return postToUpdate;
    }

    @Transactional
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
