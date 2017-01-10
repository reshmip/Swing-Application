/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Person;

import java.util.ArrayList;

/**
 *
 * @author Reshmi
 */
public class MemberDirectory {
    private ArrayList<Member> memberDirectory;
    
    public MemberDirectory(){
        memberDirectory = new ArrayList<Member>();
    }

    public ArrayList<Member> getMemberDirectory() {
        return memberDirectory;
    }

    public void setMemberDirectory(ArrayList<Member> memberDirectory) {
        this.memberDirectory = memberDirectory;
    }
    
    public Member addMember(Member member)
    {
       // member = new Member();
        memberDirectory.add(member);
        return member;
    }
}
