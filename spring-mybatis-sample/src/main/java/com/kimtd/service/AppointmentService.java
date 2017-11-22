package com.kimtd.service;

import com.kimtd.entity.Appointment;
import org.apache.ibatis.annotations.Param;

public interface AppointmentService {

    int insertAppointment(@Param("bookId") long bookId, @Param("studentId") long studentId);

    Appointment queryByKeyWithBook(@Param("bookId") long bookId, @Param("studentId") long studentId);

}
