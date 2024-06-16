package dao;

import static org.junit.jupiter.api.Assertions.*;
import pojos.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CandidatesDaoImplTest {
  private CandidatesDaoImpl candidateDao;
	
	@BeforeEach
	void setUp() throws Exception{
	System.out.println("in setup");
	candidateDao=new CandidatesDaoImpl();
	}
	
	
	@Test
	void testGetAllCandidates() throws Exception{
		List<Candidates>allCandidateNames=candidateDao.getAllCandidates();
		System.out.println(allCandidateNames);
		assertEquals(5, allCandidateNames.size());
	}

}
