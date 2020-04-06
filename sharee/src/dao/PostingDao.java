package dao;

import java.util.List;

import model.Posting;
import model.User;

public interface PostingDao {
	
	List<Posting> queryPosting(Integer current);
	void save(Posting posting);
}
