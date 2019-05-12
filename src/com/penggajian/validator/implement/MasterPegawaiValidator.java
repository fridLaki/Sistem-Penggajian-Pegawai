/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.penggajian.validator.implement;

import com.penggajian.entity.MasterPegawai;
import com.penggajian.validator.AbstractValidator;
import com.penggajian.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author MY-IT-STAF
 */
@Component
public class MasterPegawaiValidator extends AbstractValidator<MasterPegawai>{

    @Override
    protected void doValidate(MasterPegawai data) throws ValidatorException {
        if (data==null) {
            throwValidatorException("Master Pegawai tidak boleh null");
        } else if (data.getNama()==null) {  
            throwValidatorException("Nama tidak boleh null");
        } else if (data.getNama().trim().isEmpty()) {  
            throwValidatorException("Nama tidak boleh kosong");
        } else if (data.getNip()==null) {  
            throwValidatorException("NIP tidak boleh null");
        } else if (data.getNip().trim().isEmpty()) {  
            throwValidatorException("NIP tidak boleh kosong");
        } else if (data.getPendidikan()==null) {  
            throwValidatorException("Pendidikan tidak boleh null");
        } else if (data.getPendidikan().trim().isEmpty() || data.getPendidikan().startsWith("--")) {  
            throwValidatorException("Pendidikan tidak boleh kosong");
        } else if (data.getStatusSipil()==null) {  
            throwValidatorException("Status Sipil tidak boleh null");
        } else if (data.getStatusSipil().trim().isEmpty() || data.getStatusSipil().startsWith("--")) {  
            throwValidatorException("Status Sipil tidak boleh kosong");
        } else if (data.getStatusKepegawaian()==null) {  
            throwValidatorException("Status Kepegawaian tidak boleh null");
        } else if (data.getStatusKepegawaian().trim().isEmpty() || data.getStatusKepegawaian().startsWith("--")) {  
            throwValidatorException("Status Kepegawaian tidak boleh kosong");
        } else if (data.getSubstatusKepegawaian()==null) {  
            throwValidatorException("Sub Status Kepegawaian tidak boleh null");
        } else if (data.getSubstatusKepegawaian().trim().isEmpty() || data.getSubstatusKepegawaian().startsWith("--")) {  
            throwValidatorException("Sub Status Kepegawaian tidak boleh kosong");
        } else if (data.getJabatan()==null) {  
            throwValidatorException("Jabatan tidak boleh null");
        } else if (data.getJabatan().trim().isEmpty() || data.getJabatan().startsWith("--")) {  
            throwValidatorException("Jabatan tidak boleh kosong");
        } else if (data.getUnitKerja()==null) {  
            throwValidatorException("Tingkat tidak boleh null");
        } else if (data.getUnitKerja().trim().isEmpty() || data.getUnitKerja().startsWith("--")) {  
            throwValidatorException("Tingkat tidak boleh kosong");
        } else if (data.getGolongan()==null) {  
            throwValidatorException("Golongan tidak boleh null");
        } else if (data.getGolongan().trim().isEmpty() || data.getGolongan().startsWith("--")) {  
            throwValidatorException("Golongan tidak boleh kosong");
        } else if (data.getSubGolongan()==null) {  
            throwValidatorException("Sub Golongan tidak boleh null");
        } else if (data.getSubGolongan().trim().isEmpty() || data.getSubGolongan().startsWith("--")) {  
            throwValidatorException("Sub Golongan tidak boleh kosong");
        } else if (data.getMasaKerjaGolongan()==null) {  
            throwValidatorException("Masa Kerja Golongan tidak boleh null");
        } else if (data.getMasaKerjaGolongan().trim().isEmpty() || data.getMasaKerjaGolongan().startsWith("--")) {  
            throwValidatorException("Masa Kerja Golongan tidak boleh kosong");
        }
    }
    
}
