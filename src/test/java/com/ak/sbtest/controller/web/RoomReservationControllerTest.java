package com.ak.sbtest.controller.web;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ak.sbtest.domain.RoomReservation;
import com.ak.sbtest.domain.service.RoomReservationService;
import com.ak.sbtest.utils.DateUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(RoomReservationController.class)
public class RoomReservationControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private RoomReservationService roomReservationService;
    
    @Test
    public void should_return_reservation() throws Exception {
        List<RoomReservation> roomReservations = new ArrayList<>();
        roomReservations.add(RoomReservation.builder().lastName("QWE").build());
        Date date = DateUtils.createDateFromString("2020-01-01");
        when(roomReservationService.getRoomReservationForDate(date)).thenReturn(roomReservations);
        
        mockMvc.perform(get("/roomReservations?date=2020-01-01"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("QWE")))
                .andReturn();
    }
}
