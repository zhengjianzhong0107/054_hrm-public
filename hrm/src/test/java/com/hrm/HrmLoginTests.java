package com.hrm;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.StopWatch;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hrm.dto.Response;
import com.hrm.dto.ResponseDTO;
import com.hrm.entity.*;
import com.hrm.enums.BusinessStatusEnum;
import com.hrm.mapper.DeptMapper;
import com.hrm.mapper.InsuranceMapper;
import com.hrm.mapper.RoleMenuMapper;
import com.hrm.mapper.StaffMapper;
import com.hrm.service.*;
import com.hrm.util.DatetimeUtil;
import com.hrm.util.HutoolExcelUtil;
import com.hrm.util.JWTUtil;
import com.hrm.util.MD5Util;
import com.hrm.vo.DeptWorkTimeVO;
import com.hrm.vo.StaffDeptVO;
import com.hrm.vo.StaffInsuranceVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HrmLoginTests {

    @Autowired
    private StaffService staffService;

    @Resource
    private StaffMapper staffMapper;


    @Test
    void test1() {
        String password = MD5Util.MD55("12345");
        StaffDeptVO staffDeptVO = this.staffMapper.findStaffInfo("admin", password);
        if (staffDeptVO != null) {
            // 验证用户状态
            if (staffDeptVO.getStatus() == 1) {
                String token = JWTUtil.generateToken(staffDeptVO.getId(), password);
                System.out.println(Response.success(staffDeptVO, token)); // 返回员工信息和token
                return;
            }
            throw new RuntimeException(BusinessStatusEnum.STAFF_STATUS_ERROR.getMessage());
        }
        throw new RuntimeException("用户名或密码错误！");
    }

    @Test
    void test2() {
        String password = MD5Util.MD55("123456");
        StaffDeptVO staffDeptVO = this.staffMapper.findStaffInfo("admin2", password);
        if (staffDeptVO != null) {
            // 验证用户状态
            if (staffDeptVO.getStatus() == 1) {
                String token = JWTUtil.generateToken(staffDeptVO.getId(),password);
                System.out.println(Response.success(staffDeptVO, token)); // 返回员工信息和token
                return;
            }
            throw new RuntimeException(BusinessStatusEnum.STAFF_STATUS_ERROR.getMessage());
        }
        throw new RuntimeException("用户名或密码错误！");
    }

    @Test
    void test3() {
        String password = MD5Util.MD55("12345");
        StaffDeptVO staffDeptVO = this.staffMapper.findStaffInfo("admin2", password);
        if (staffDeptVO != null) {
            // 验证用户状态
            if (staffDeptVO.getStatus() == 1) {
                String token = JWTUtil.generateToken(staffDeptVO.getId(),password);
                System.out.println(Response.success(staffDeptVO, token)); // 返回员工信息和token
                return;
            }
            throw new RuntimeException(BusinessStatusEnum.STAFF_STATUS_ERROR.getMessage());
        }
        throw new RuntimeException("用户名或密码错误！");
    }

    @Test
    void test4() {
        String password = MD5Util.MD55("123456");
        StaffDeptVO staffDeptVO = this.staffMapper.findStaffInfo(null, password);
        if (staffDeptVO != null) {
            // 验证用户状态
            if (staffDeptVO.getStatus() == 1) {
                String token = JWTUtil.generateToken(staffDeptVO.getId(),password);
                System.out.println(Response.success(staffDeptVO, token)); // 返回员工信息和token
                return;
            }
            throw new RuntimeException(BusinessStatusEnum.STAFF_STATUS_ERROR.getMessage());
        }
        throw new RuntimeException("用户名或密码错误！");
    }

}
