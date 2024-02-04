package org.example.mallapi.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.mallapi.domain.Member;
import org.example.mallapi.dto.MemberDTO;
import org.example.mallapi.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Log4j2
public class CustomUserDetailService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("-----------------loadUserByUsername-------------------" + username);

        Member member = memberRepository.getWithRoles(username);

        if (member == null) {
            throw new UsernameNotFoundException("Not found");
        }

        MemberDTO memberDTO = new MemberDTO(
          member.getEmail(),
          member.getPw(),
          member.getNickname(),
          member.isSocial(),
          member.getMemberRoleList().stream().map(memberRole -> memberRole.name()).collect(Collectors.toList())
        );

        log.info(memberDTO);

        return memberDTO;
    }
}
