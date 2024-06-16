package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import pojos.*;

public interface CandidatesDao {
List<Candidates> getAllCandidates() throws SQLException;

String incrementCandidateVotes(int candidateId) throws SQLException;


Map<String, Integer> getPartyWiseVotes() throws SQLException;
	
List<Candidates> getTop2Candidates() throws SQLException;
}
