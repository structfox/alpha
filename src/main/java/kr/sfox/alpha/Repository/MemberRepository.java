package kr.sfox.alpha.Repository;

import jakarta.persistence.EntityManager;
import kr.sfox.alpha.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    final private EntityManager entityManager;

    public void save(Member member) {
        entityManager.persist(member);
    }
}
