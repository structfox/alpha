package kr.sfox.alpha.api.memberDto.response;

import lombok.Data;

@Data
public class JoinMemberResponse {
    private Long id;

    public JoinMemberResponse(Long id) {
        this.id = id;
    }
}
