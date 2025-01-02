package kr.sfox.alpha.api;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.sfox.alpha.domain.Post;
import kr.sfox.alpha.service.PostService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostApiController {

    private final PostService postService;

    @PostMapping
    public Post createBoard(@RequestBody Post board) {
        return postService.createPost(board);
    }

    @GetMapping
    public List<Post> getAllBoards() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Optional<Post> getBoardById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PatchMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        return postService.updatePost(id, updatedPost);
    }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
