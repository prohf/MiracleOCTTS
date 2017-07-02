package cn.miracle.octts.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Tony on 2017/7/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GroupConfirmMemberServiceTest {

    @Autowired
    GroupConfirmMemberService groupConfirmMemberService;

    @Test
    public void testFindGroupConfirmMemberListByGroupId() {
       groupConfirmMemberService.findGroupConfirmMemberListByGroupId(1);
    }

    @Test
    public void testFindGidBySid() {
        Integer gid = groupConfirmMemberService.findGroupIdByStudentId("14215555");
        assertEquals(gid, new Integer(1));
    }
}
