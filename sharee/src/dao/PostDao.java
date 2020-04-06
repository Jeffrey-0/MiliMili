package dao;

import java.util.List;

import model.Post;
import model.Posting;



public interface PostDao {
	Posting queryPosting(Integer id);
	List<Post> querypost(Integer post_id);
	List<Post> querypostsss(Integer post_id);
	Post queryname(Integer post_id, Integer post_stprey_id);
	void savepost(Post post);
	int postnum(Integer post_id);
	void savegailou(Post post);
}
