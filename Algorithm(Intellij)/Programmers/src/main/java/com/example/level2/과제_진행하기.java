package com.example.level2;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 과제_진행하기 {

    static List<Subject> subjects = new ArrayList<>();
    static List<String> done = new ArrayList<>();
    static List<Subject> inProgress = new ArrayList<>();

    public static void main(String[] args) {
        String[][] plans = new String[][]{
                new String[]{"science","12:40","50"},
                new String[]{"music","12:20","40"},
                new String[]{"history","14:00","30"},
                new String[]{"computer","12:30","100"}
        };
        for(String[] plan : plans){
            addSubject(plan);
        }
        sortByTime(subjects);

        for(Subject s : subjects){
            if(inProgress.isEmpty()){
                inProgress.add(s);
            }else{
                int restTime = s.time - inProgress.get(0).time;
                consumeTime(restTime);
                inProgress.add(0, s);
            }
        }

        for(Subject s : inProgress){
            done.add(s.name);
        }

        for(String name : done){
            System.out.print(name+" ");
        }

    }

    public static void consumeTime(int time){
        int restTime = time;
        List<Subject> copyInProgress = new ArrayList<>(inProgress);
        for(Subject s : copyInProgress){
            if(restTime >= s.restTime){
                restTime -= s.restTime;
                inProgress.remove(0);
                done.add(s.name);
            }else{
                s.restTime -= restTime;
                break;
            }
        }
    }

    public static void sortByTime(List<Subject> subjects){
        subjects.sort(Comparator.comparingInt(s -> s.time));
    }

    public static void addSubject(String[] plan){
        subjects.add(new Subject(plan[0], plan[1], plan[2]));
    }

    public static class Subject{
        String name;
        int time;
        int restTime;

        public Subject(String name, String time, String resultTime){
            this.name = name;
            this.time = timeToMin(time);
            this.restTime = Integer.parseInt(resultTime);
        }

        private int timeToMin(String time){
            String[] times = time.split(":");
            return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
        }
    }
}
