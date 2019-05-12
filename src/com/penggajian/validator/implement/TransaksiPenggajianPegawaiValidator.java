/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.penggajian.validator.implement;

import com.penggajian.entity.MasterPegawai;
import com.penggajian.entity.TransaksiPenggajianPegawai;
import com.penggajian.validator.AbstractValidator;
import com.penggajian.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author MY-IT-STAF
 */
@Component
public class TransaksiPenggajianPegawaiValidator extends AbstractValidator<TransaksiPenggajianPegawai>{

    @Override
    protected void doValidate(TransaksiPenggajianPegawai data) throws ValidatorException {
        if (data==null) {
            throwValidatorException("Master Pegawai tidak boleh null");
//        } else if (data.getNamaPeg()==null) {  
//            throwValidatorException("Nama tidak boleh null");
        } else if (data.getMp().getNip()==null) {  
            throwValidatorException("NIP tidak boleh null");
        } else if (data.getBulan()==null) {  
            throwValidatorException("Bulan tidak boleh null");
        }
    }
    
}
