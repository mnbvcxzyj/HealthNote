package com.sosigae.LuckeyTurkey.service;

import com.sosigae.LuckeyTurkey.dao.mybatis.mapper.DoctorMapper;
import com.sosigae.LuckeyTurkey.domain.Doctor;
import com.sosigae.LuckeyTurkey.domain.MedicalRecord;
//import com.sosigae.LuckeyTurkey.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;

    // 의사 검색
    public List<Doctor> searchDoctors(String name, String department) {
        if (!name.isEmpty() && !department.isEmpty()) {
            return doctorMapper.searchDoctorsByNameAndDepartment(name, department);
        }
        if (!name.isEmpty()) {
            return doctorMapper.searchDoctorsByName(name);
        }
        if (!department.isEmpty()) {
            return doctorMapper.searchDoctorsByDepartment(department);
        }
        return new ArrayList<>();
    }

    // 의사 정보
    public Doctor getDocInfo(int doctorId) {
        return doctorMapper.getDocInfo(doctorId);
    }

    // 전체 의사 목록
    public List<Doctor> getAllDoctors() {
        return doctorMapper.getAllDoctors();
    }

    // 특정 의사 전체 진료 기록 조회
    public List<MedicalRecord> getMedRecordList(int doctorId) {return doctorMapper.getMedRecordList(doctorId);}

    // 의사 환자 진료기록 추가
    public void addMedRecord(MedicalRecord medicalRecord) {doctorMapper.addMedRecord(medicalRecord);}

}