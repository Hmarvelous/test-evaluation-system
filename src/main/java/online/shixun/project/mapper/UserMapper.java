package online.shixun.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import online.shixun.project.dto.UserDto;

/**
 * 
 * @ClassName: UserMapper.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: am
 * @date: 2019年10月23日 下午4:47:22
 */
@Mapper
public interface UserMapper {

	/**
	 * 通过用户名查询用户信息
	 * @param username 用户名
	 * @return 用户对象
	 */
	UserDto selectUserByUsername(@Param("username") String username);
}
