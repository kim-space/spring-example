package com.kimtd.service;

import com.kimtd.entity.Appointment;
import com.kimtd.mapper.AppointmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Override
    public int insertAppointment(long bookId, long studentId) {
        return appointmentMapper.insertAppointment(bookId,studentId);
    }

    @Override
    public Appointment queryByKeyWithBook(long bookId, long studentId) {
        return appointmentMapper.queryByKeyWithBook(bookId,studentId);
    }
}
