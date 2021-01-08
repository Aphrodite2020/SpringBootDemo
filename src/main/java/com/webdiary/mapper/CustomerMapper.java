package com.webdiary.mapper;

import com.webdiary.entity.Customer;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Mapper
@Repository //可以消除service层的红线，即使是红线也可以运行没差
//@Repository和@Controller、@Service、@Component的作用差不多，都是把对象交给spring管理。
// @Repository用在持久层的接口上，这个注解是将接口的一个实现类交给spring管理。
public interface CustomerMapper {

    @Select("select * from customer where customer_name = #{customer_name}")
    @ResultMap("customerResult")
    Customer selectByCustomerName(String customerName);

    @Delete({
        "delete from customer",
        "where customer_id = #{customerId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer customerId);

    @Insert({
        "insert into customer (customer_name, login_count, ",
        "last_login_time, customer_password)",
        "values (#{customerName,jdbcType=VARCHAR}, #{loginCount,jdbcType=INTEGER}, ",
        "#{lastLoginTime,jdbcType=TIMESTAMP}, #{customerPassword,jdbcType=VARBINARY})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="customerId", before=false, resultType=Integer.class)
    int insert(Customer record);

    @Select({
        "select",
        "customer_id, customer_name, login_count, last_login_time, customer_password",
        "from customer",
        "where customer_id = #{customerId,jdbcType=INTEGER}"
    })
    @Results(id = "customerResult", value = {
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="login_count", property="loginCount", jdbcType=JdbcType.INTEGER),
        @Result(column="last_login_time", property="lastLoginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="customer_password", property="customerPassword", jdbcType=JdbcType.VARBINARY)
    })
    Customer selectByPrimaryKey(Integer customerId);

    @Select({
        "select",
        "customer_id, customer_name, login_count, last_login_time, customer_password",
        "from customer"
    })
    @Results({
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="login_count", property="loginCount", jdbcType=JdbcType.INTEGER),
        @Result(column="last_login_time", property="lastLoginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="customer_password", property="customerPassword", jdbcType=JdbcType.VARBINARY)
    })
    List<Customer> selectAll();

    @Update({
        "update customer",
        "set customer_name = #{customerName,jdbcType=VARCHAR},",
          "login_count = #{loginCount,jdbcType=INTEGER},",
          "last_login_time = #{lastLoginTime,jdbcType=TIMESTAMP},",
          "customer_password = #{customerPassword,jdbcType=VARBINARY}",
        "where customer_id = #{customerId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Customer record);
}