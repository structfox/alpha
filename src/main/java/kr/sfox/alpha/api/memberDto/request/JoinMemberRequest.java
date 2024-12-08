package kr.sfox.alpha.api.memberDto.request;

import lombok.Data;

@Data
public class JoinMemberRequest {
    private String userId;
    private String password;
}
