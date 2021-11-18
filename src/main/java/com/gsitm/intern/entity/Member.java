package com.gsitm.intern.entity;

import com.gsitm.intern.constant.Role;
import com.gsitm.intern.dto.MemberFormDto;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.OAuth2AccessToken;

import javax.persistence.*;

@Entity
@Table(name="member")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Member extends BaseEntity {

    @Id
    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String address;

    private int point; // 개인프로젝트

    @Enumerated(EnumType.STRING)
    private Role role;

    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder){
        Member member = new Member();
        member.setName(memberFormDto.getName());
        member.setEmail(memberFormDto.getEmail());
        member.setAddress(memberFormDto.getAddress());
        member.setPoint(memberFormDto.getPoint());
        String password = passwordEncoder.encode(memberFormDto.getPassword());
        member.setPassword(password);
        member.setRole(Role.ADMIN);
        return member;
    }

}