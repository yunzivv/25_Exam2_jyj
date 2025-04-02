package org.example.motivation.service;

import org.example.container.Container;
import org.example.motivation.entity.Motivation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MotivationService {

    List<Motivation> motivations;

    public MotivationService() {
        motivations = new ArrayList<Motivation>();
    }

    public boolean moivationIsExist() {

        if (motivations.size() == 0) {
            return false;
        }
        return true;
    }

    public Motivation getMotivation(int id) {
        for (Motivation motivation : motivations) {
            if (motivation.getId() == id) {
                return motivation;
            }
        }
        return null;
    }

    public void showList() {

        for (int i = motivations.size() - 1; i >= 0; i--) {
            Motivation motivation = motivations.get(i);

            int id = motivation.getId();
            String author = motivation.getAuthor();
            String body = motivation.getBody();

            System.out.printf("%d  /  %s  /   %s\n", id, author, body);
        }

    }

    public void doAdd(int lastId, String body, String author) {

        String regDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        motivations.add(new Motivation(lastId, regDate, author, body));

    }

    public void doModify(int id) {

        Motivation motivation = null;

        for (Motivation m : motivations) {
            if (m.getId() == id) {
                motivation = m;
            }
        }

        System.out.println("명언(기존) : " + motivation.getBody());
        System.out.println("작가(기존) : " + motivation.getAuthor());

        System.out.print("명언 : ");
        String body = Container.getScanner().nextLine();
        System.out.print("작가 : ");
        String author = Container.getScanner().nextLine();

        motivation.setBody(body);
        motivation.setAuthor(author);
    }

    public void doDelete(int deleteId) {

        for (Motivation m : motivations) {
            if (m.getId() == deleteId) {
                motivations.remove(m);
            }
        }

    }

    public void showDetail(int detailId) {
        Motivation motivation = null;
        for (Motivation m : motivations) {
            if (m.getId() == detailId) {
                motivation = m;
            }
        }
        System.out.println("번호 : " + motivation.getId());
        System.out.println("날짜 : " + motivation.getRegDate());
        System.out.println("작가 : " + motivation.getAuthor());
        System.out.println("내용  : " + motivation.getBody());
    }
}
