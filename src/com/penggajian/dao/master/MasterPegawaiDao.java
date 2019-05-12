/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.penggajian.dao.master;

import com.penggajian.dao.BaseDaoHibernate;
import com.penggajian.entity.MasterPegawai;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MY-IT-STAF
 */
@Repository
public class MasterPegawaiDao extends BaseDaoHibernate<MasterPegawai> {
    
    public MasterPegawai findByID(String id){
        return (MasterPegawai) sessionFactory.getCurrentSession().createQuery("SELECT m FROM MasterPegawai m WHERE m.id = :id").setString("id", id).uniqueResult();
    }
    
}
