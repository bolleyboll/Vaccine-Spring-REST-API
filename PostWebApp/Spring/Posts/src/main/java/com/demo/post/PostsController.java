package com.demo.post;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import org.springframework.web.bind.annotation.RequestMethod;

import dao.PostDAOImpl;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT })
@RequestMapping("posts")
public class PostsController {
	
	PostDAOImpl impl = new PostDAOImpl();
	@GetMapping("/all")
	public List<Post> getPost(){
		return impl.view();
	}
	@PostMapping("/add")
	public Post addPost(@RequestBody Post post) {
		return impl.insert(post);
	}
	@PutMapping("/update/{id}")
	public Post updatePost(@RequestBody Post post,@PathVariable int id) {
		return impl.update(new Post(id,post.getTitle(),post.getBody()));
		
	}
	@DeleteMapping("/delete/{id}")
	public Status deletePost(@PathVariable int id) {
		return impl.delete(new Post(id,"",""));
	}
	@GetMapping("/all/{id}")
	public Post getById(@PathVariable int id) {
		return impl.findById(new Post(id,"",""));
	}
}
