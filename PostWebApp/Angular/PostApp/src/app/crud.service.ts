import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CrudService {
  posts : any[]
  constructor(public http : HttpClient) {
   }
  getPosts(){
    this.http.get("http://localhost:8080/posts/all").subscribe((data : any[]) => this.posts=data)
  }

  addPosts(Post){
    this.http.post("http://localhost:8080/posts/add", Post).subscribe(res =>{
      this.posts.unshift(res)
    })
  }
}
