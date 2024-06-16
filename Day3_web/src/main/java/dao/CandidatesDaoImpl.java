package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import pojos.*;
import static utils.DbUtils.openConnection;


public class CandidatesDaoImpl implements CandidatesDao {

	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
	private PreparedStatement pst3;
	private PreparedStatement pst4;
	
	public CandidatesDaoImpl() throws ClassNotFoundException,SQLException{
		cn=openConnection();
		pst1 = cn.prepareStatement("select * from candidates");
		pst2 = cn.prepareStatement("update candidates set votes=votes+1 where id=?");
		pst3 = cn.prepareStatement("select party,sum(votes) from candidates group by party");
		pst4 = cn.prepareStatement("select * from candidates order by votes desc limit 2");
		System.out.println("candidates dao created...");
	}
	
	@Override
	public List<Candidates> getAllCandidates() throws SQLException {
		List<Candidates> candidateNames=new ArrayList<>();
		
		try(ResultSet rst=pst1.executeQuery())
		{
		  while(rst.next())
			  candidateNames.add(new Candidates(rst.getInt(1),rst.getString(2), rst.getString(3), rst.getInt(4)));
		}
		
		return candidateNames;
	}

	@Override
	public String incrementCandidateVotes(int candidateId) throws SQLException {
		// set IN param : candidate id
		pst2.setInt(1, candidateId);
		int updateCount = pst2.executeUpdate();
		if (updateCount == 1)
			return "Votes updated...";
		else
		return "Votes updation failed !!!!!!!!!!!!";
	}
	
	@Override
	public Map<String, Integer> getPartyWiseVotes() throws SQLException {
		// ordered map
		Map<String, Integer> map = new LinkedHashMap<>();
		try (ResultSet rst = pst3.executeQuery()) {
			while (rst.next())
				map.put(rst.getString(1), rst.getInt(2));
		}
		return map;
	}

	@Override
	public List<Candidates> getTop2Candidates() throws SQLException {
		List<Candidates> list = new ArrayList<>();
		try (ResultSet rst = pst4.executeQuery()) {
			while (rst.next())
				list.add(new Candidates(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
		}
		return list;
	}
	
	public void cleanUp() throws SQLException
	{
		if(pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		System.out.println("candidates dao cleaned..");
	}
}
