package com.knock.bmt.common.enums;

import java.util.HashMap;
import java.util.Map;

public enum UserRoleType {
    ANONYMOUS("ROLE_ANONYMOUS", "익명사용자", 0),    // 가입도 안한 상태
    GUEST("ROLE_GUEST", "손님", 1),   // 가입은 했으나 인증은 안한상태
    USER("ROLE_USER", "일반사용자", 2),

    // 관리자
    ADMIN("ROLE_ADMIN", "관리자", 3),
    ROOT("ROLE_ROOT", "최고 관리자", 4);

    private final String code;
    private final String label;
    private final int level;
    private static final Map<String, UserRoleType> BY_CODE = new HashMap<>();

    UserRoleType(String code, String label, int level) {
        this.code = code;
        this.label = label;
        this.level = level;
    }

    static {
        for (UserRoleType e : values()) {
            BY_CODE.put(e.code, e);
        }
    }

    public static UserRoleType ofCode(String code) {
        return BY_CODE.get(code);
    }
}
