package ch12;

import java.util.ArrayList;
import java.util.List;

public class 스킬_트리 {

    public static void main(String[] args) {
        System.out.println(
                Solution.solution("CBD",
                        new String[]{"BACDE", "CBADF", "AECB", "BDA"})
        );
    }
    static class Solution {

        public static String staticSkill;
        public static String[] staticSkillTrees;
        public static int solution(String skill, String[] skill_trees) {
            int answer = 0;
            staticSkill = skill;
            staticSkillTrees = skill_trees;

            for(String eachSt : skill_trees){
                if(checkSkillTree(eachSt)){
                    answer++;
                }
            }
            return answer;
        }

        public static boolean checkSkillTree(String eachSt){
            List<Character> skillOrder = new ArrayList<>();

            for(Character c : staticSkill.toCharArray()){
                skillOrder.add(c);
            }

            // 스킬 트리에 포함된 스킬이며, 가장 처음에 배워야 할 스킬이 아니면 false
            for(Character c : eachSt.toCharArray()){
                if(skillOrder.contains(c)){
                    if(skillOrder.get(0) != c){
                        return false;
                    }
                    skillOrder.remove(0);
                }
            }
            return true;
        }
    }
}
