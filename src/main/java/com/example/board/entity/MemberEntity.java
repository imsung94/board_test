package com.example.board.entity;


import com.example.board.dto.MemberDto;
import com.example.board.repository.MemberRepository;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode()
@Entity
@Table(name = "MEMBER")
public class MemberEntity extends MemberRepository {

    @Id
    @Column(name = "USERID", length = 50, nullable = false )
    private String userId;

    @Column(name = "PASSWARD", length = 50, nullable = false )
    private String password;

    @Column(name = "NAME", length = 50, nullable = false )
    private String name;

    @Column(name = "PHONENUMBER", length = 50 )
    private String phoneNumber;

    @Column(name = "EMAIL", length = 50 )
    private String email;

}
