package dao;

import java.util.List;

import com.demo.post.Post;
import com.demo.post.Status;




public interface PostDAO {
	
	Post insert(Post post);
	Post update(Post post);
	Status delete(Post post);
	List<Post> view();
	Post findById(Post post);
}
