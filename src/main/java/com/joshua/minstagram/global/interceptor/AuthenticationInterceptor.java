package com.joshua.minstagram.global.interceptor;

public class AuthenticationInterceptor {

}

//@Slf4j
//@RequiredArgsConstructor
//@Component
//public class AuthenticationInterceptor implements HandlerInterceptor {
//
//    private final MemberService memberService;
//
//    private final JWTUtils jwtUtils;
//
//    @Override
//    public boolean preHandle(final HttpServletRequest request,
//                             final HttpServletResponse response,
//                             final Object handler) {
//        if (isAuthRequired(handler)) {
//            final AuthRequired authRequired = Objects.requireNonNull(((HandlerMethod) handler)
//                    .getMethodAnnotation(AuthRequired.class));
//
//            String accessToken = jwtUtils.getAccessToken(request);
//            final String refreshToken = jwtUtils.getRefreshToken(request);
//
//            if (isTokenEmpty(accessToken) || (isTokenEmpty(refreshToken)))
//                throw new AuthenticationException.InvalidToken();
//
//            try {
//                jwtUtils.verify(accessToken);
//            } catch (TokenExpiredException e) {
//                log.debug("Access token expiration");
//                try {
//                    jwtUtils.verify(refreshToken);
//
//                    accessToken = refreshToken(response, refreshToken);
//                } catch (JWTVerificationException e1) {
//                    log.error("Refresh token invalid");
//                    throw new AuthenticationException.InvalidToken();
//                }
//            } catch (JWTVerificationException e) {
//                log.error("Access token invalid");
//                throw new AuthenticationException.InvalidToken();
//            }
//
//            final Member member = memberService.findById(JWTUtils.getMemberId(accessToken));
//
//            if (isInvalidRole(authRequired, member.getRole()))
//                throw new AccessDeniedException();
//
//            MemberContext.setAuthentication(MemberAuthentication.from(member));
//        }
//
//        return true;
//    }
//
//    public boolean isAuthRequired(final Object handler) {
//        return handler instanceof HandlerMethod && ((HandlerMethod) handler).hasMethodAnnotation(AuthRequired.class);
//    }
//
//    public boolean isInvalidRole(final AuthRequired authRequired,
//                                 final Role role) {
//        if (authRequired.without())
//            return role.contains(authRequired.roles());
//
//        return !role.contains(authRequired.roles());
//    }
//
//    @Override
//    public void postHandle(final HttpServletRequest request,
//                           final HttpServletResponse response,
//                           final Object handler,
//                           final ModelAndView modelAndView) {
//        MemberContext.clearAuthentication();
//    }
//
//    private String refreshToken(final HttpServletResponse response,
//                                final String token) {
//        final String accessToken = jwtUtils.generateAccessToken(JWTUtils.getMemberId(token), JWTUtils.getMemberEmail(token));
//        jwtUtils.setAuthorization(response, accessToken);
//
//        return accessToken;
//    }
//
//    private boolean isTokenEmpty(final String token) {
//        return token == null || token.isBlank();
//    }
//
//}
