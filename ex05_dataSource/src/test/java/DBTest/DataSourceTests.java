package DBTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.app.domain.Dao.MemoDaoImpl;
import com.example.app.domain.Dto.MemoDto;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
class DataSourceTests {
	
	@Autowired
	private DataSource dataSource1;
	
	@Autowired
	private MemoDaoImpl memoDaoImpl;
	
	@Test
	void test1() throws Exception{
		System.out.println(dataSource1);
		Connection con = dataSource1.getConnection();
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO tbl_book VALUES('abcd','abcd','abcd','abcd')");
		ResultSet rs;
		pstmt.executeUpdate();
	
	}
	@Test
	void test2() throws Exception{
		memoDaoImpl.insert(new MemoDto(1, "a", "a", LocalDateTime.now(), null));
	}
}
