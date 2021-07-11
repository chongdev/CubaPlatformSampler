package com.company.cubaplatformsampler.service;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import com.company.cubaplatformsampler.entity.Speaker;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service(SpeakerService.NAME)
public class SpeakerServiceBean implements SpeakerService {

    @Inject
    private Persistence persistence;

    @Inject
    private DataManager dataManager;

    @Override
    public String findUser(String name) {
        String speaker;

        try {
            // TODO เปิด Transaction
            Transaction tx = persistence.createTransaction();
            EntityManager em = persistence.getEntityManager();

            // TODO select ข้อมูล + Parameter
            Query q = em.createNativeQuery("select s from cubaplatformsampler_Speaker s WHERE s.firstName=:FIRST_NAME");
            q.setParameter("FIRST_NAME", name);

            // TODO เก็บข้อมูลไว้ในตัวแปร
            speaker = (String) q.getSingleResult();

            // TODO commit
            tx.commit();

            return speaker;

        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public List<Speaker> find(String id) {
        List<Speaker> users = new ArrayList<>();

        try {
            // TODO เปิด Transaction
            Transaction tx = persistence.createTransaction();
            EntityManager em = persistence.getEntityManager();

            // TODO select ข้อมูล + Parameter
            Query q = em.createNativeQuery("SELECT * FROM cubaplatformsampler_Speaker WHERE id=:id");
            q.setParameter("id", id);

            // TODO เก็บข้อมูลไว้ในตัวแปร
            users = q.getResultList();

            // TODO commit
            tx.commit();

            return users;

        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public List<Speaker> getUser() {
        List<Speaker> res = dataManager.load(Speaker.class)
                .query("SELECT e FROM cubaplatformsampler_Speaker e")
                .list();

        return res;


//        List<Speaker> users = new ArrayList<>();
//
//        try {
//            // TODO เปิด Transaction
//            Transaction tx = persistence.createTransaction();
//            EntityManager em = persistence.getEntityManager();
//
//            // TODO select ข้อมูล + Parameter
//            Query q = em.createNativeQuery("SELECT s FROM cubaplatformsampler_Speaker s");
//
//            // TODO เก็บข้อมูลไว้ในตัวแปร
//            users = q.getResultList();
//
//            // TODO commit
//            tx.commit();
//
//            return users;
//
//        } catch (Exception ex) {
//            return null;
//        }
    }
}