package kr.sfox.alpha.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import kr.sfox.alpha.domain.Member;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager entityManager;

    public void save(Member member) {
        entityManager.persist(member);
    }

    public Member findById(Long id) {
        return entityManager.find(Member.class, id);
    }

    public void removeMember(Member member) {
        entityManager.remove(member);
    }

    public Member findByUserId(String userId) {
        return entityManager.createQuery("select m from Member m where m.userId = :userId", Member.class)
            .setParameter("userId", userId)
            .getResultList().getFirst();
    }
}
