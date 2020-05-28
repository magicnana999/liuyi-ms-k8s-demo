package com.creolophus.liuyi.common.security;

/**
 * @author magicnana
 * @date 2019/7/2 上午12:11
 */
public class UserSecurity {

    private Long userId;
    private String token;
    private Long timestamp;

    public UserSecurity(){}

    public UserSecurity(String token){
        this.userId =System.currentTimeMillis();
        this.timestamp = System.currentTimeMillis();
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    //    @JSONField(serialize = false)
//    public UserDetails transfer(){
//
//        return new UserDetails() {
//            @Override
//            public Collection<? extends GrantedAuthority> getAuthorities() {
//                if(type != null && type == 1) {
//                    return Arrays.asList(new SimpleGrantedAuthority("ROLE_VIP"));
//                }
//                return Collections.emptyList();            }
//
//            @Override
//            public String getPassword() {
//                return "";
//            }
//
//            @Override
//            public String getUsername() {
//                return userId+"";
//            }
//
//            @Override
//            public boolean isAccountNonExpired() {
//                return true;
//            }
//
//            @Override
//            public boolean isAccountNonLocked() {
//                return true;
//            }
//
//            @Override
//            public boolean isCredentialsNonExpired() {
//                return true;
//            }
//
//            @Override
//            public boolean isEnabled() {
//                return true;
//            }
//        };
//    }


}
