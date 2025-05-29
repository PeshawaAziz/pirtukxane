package management;

import datastructures.maps.CustomHashMap;
import library.Member;
import library.Transaction;

public class MemberManager {
    private CustomHashMap<String, Member> memberMap;

    public MemberManager() {
        memberMap = new CustomHashMap<>();
    }

    public void addMember(Member member) {
        memberMap.put(member.getMemberId(), member);
    }

    public Member getMember(String memberId) {
        return memberMap.get(memberId);
    }

    public void recordTransaction(String memberId, Transaction transaction) {
        memberMap.get(memberId).addTransaction(transaction);
    }

    public Transaction getLastTransaction(String memberId) {
        return memberMap.get(memberId).getLastTransaction();
    }
}
