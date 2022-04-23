package com.joshua.minstagram.global.context;

import com.joshua.minstagram.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@Builder (access = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class UserAuthentication {

    private final Long id;

    private final String username;

    private final String name;

    private final String website;

    private final String bio;

    private final String email;

    private final String phone;

    private final String gender;

    private final String profileImage;

    public static UserAuthentication from (final @NotNull User user) {
        return UserAuthentication.builder()
                .id(user.getId())
                .username(user.getUsername())
                .name(user.getName())
                .website(user.getWebsite())
                .bio(user.getBio())
                .email(user.getEmail())
                .phone(user.getPhone())
                .gender(user.getGender())
                .profileImage(user.getProfileImage())
                .build();
    }

}

//@Getter
//@Builder(access = AccessLevel.PRIVATE)
//@RequiredArgsConstructor
//public class MemberAuthentication {
//
//    private final Long id;
//
//    private final String email;
//
//    private final String name;
//
//    private final String nickname;
//
//    private final String phoneNumber;
//
//    private final String imageUrl;
//
//    private final LocalDate birthDate;
//
//    private final LocalDate joinDate;
//
//    private final Role role;
//
//    private final WorkStatus workStatus;
//
//    private final String workMessage;
//
//    private final Long companyId;
//
//    private final Long positionId;
//
//    private final Long teamId;
//
//    public static MemberAuthentication from(Member member) {
//        return MemberAuthentication.builder()
//                .id(member.getId())
//                .email(member.getEmail())
//                .name(member.getName())
//                .nickname(member.getNickname())
//                .phoneNumber(member.getPhoneNumber())
//                .imageUrl(member.getImageUrl())
//                .birthDate(member.getBirthDate())
//                .joinDate(member.getJoinDate())
//                .role(member.getRole())
//                .workStatus(member.getWorkStatus())
//                .companyId(member.getCompany().getId())
//                .positionId(member.getPosition() != null ? member.getPosition().getId() : null)
//                .teamId(member.getTeam() != null ? member.getTeam().getId() : null)
//                .build();
//    }
//
//}
