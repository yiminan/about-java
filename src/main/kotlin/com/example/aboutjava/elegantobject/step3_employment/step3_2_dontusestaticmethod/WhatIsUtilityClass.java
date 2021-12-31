package com.example.aboutjava.elegantobject.step3_employment.step3_2_dontusestaticmethod;

/**
 * "유틸리티 클래스(Utility classes)란?"<p>
 * <p>
 * 실제로 인스턴스화가 되지않고, "편의를 위한 정적 메서드들을 모아 놓은 정적 메서드들의 컬렉션"이라고 합니다.<p>
 * 다른 말로는 헬퍼(helper)라고 부릅니다.<p>
 * 유틸리티 클래스는 어떤 것의 팩토리가 아니기 때문에 진짜 클래스라고 부를 수 없습니다.<p>
 * 의도적으로 'private contructor'를 추가해서 인스턴스화가 안되게 합니다.<p>
 * 유틸리티 클래스는 절차적인 프로그래머들이 OOP에서 거둔 승리의 상징입니다.<p>
 * 유틸리티 클래스는 나쁜 요소들을 모아 놓은 안티 패턴 집합체입니다.
 */
class WhatIsUtilityClass {

    public static void main(String[] args) {
        System.out.println(Math.max(1, 2));// 2
        System.out.println(Math.min(1, 2));// 1
    }

    private static class Math {
        private Math() {
            throw new AssertionError();// 또는 한 줄 공백이 가능합니다.
        }

        public static int max(int a, int b) {
            if (a < b) {
                return b;
            }
            return a;
        }

        public static int min(int a, int b) {
            if (a < b) {
                return a;
            }
            return b;
        }
    }
}
