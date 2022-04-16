package com.joshua.minstagram.global.context;

public class MemberContext {

}

//@Slf4j
//public class MemberContext {
//
//    private static final ThreadLocal<MemberAuthentication> MEMBER_AUTHENTICATION = new ThreadLocal<>();
//
//    private static final ThreadLocal<Locale> MEMBER_LOCALE = new ThreadLocal<>();
//
//    public static MemberAuthentication getAuthentication() {
//        MemberAuthentication memberAuthentication = MEMBER_AUTHENTICATION.get();
//        log.debug("Get member authentication");
//        return memberAuthentication;
//    }
//
//    public static void setAuthentication(MemberAuthentication memberAuthentication) {
//        log.debug("Set member authentication: {}", memberAuthentication.toString());
//        MEMBER_AUTHENTICATION.set(memberAuthentication);
//    }
//
//    public static void clearAuthentication() {
//        log.debug("Clear member authentication");
//        MEMBER_AUTHENTICATION.remove();
//    }
//
//    public static Locale getLocale() {
//        final Locale locale = MEMBER_LOCALE.get();
//        log.debug("Get locale");
//        return locale;
//    }
//
//    public static void setLocale(final @NotNull Locale locale) {
//        log.debug("Set locale: {}", locale.toString());
//        MEMBER_LOCALE.set(locale);
//    }
//
//    public static void clearLocale() {
//        log.debug("Clear locale");
//        MEMBER_LOCALE.remove();
//    }
//
//}
