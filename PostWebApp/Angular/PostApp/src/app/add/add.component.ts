import { Component, OnInit } from '@angular/core';
import {CrudService} from '../crud.service';
import { Posts } from '../Model/Posts';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css'],
})
export class AddComponent {
  post : Posts
  constructor(public crud : CrudService) {
    this.post = new Posts();
  }
  addPost(add){
    this.crud.addPosts(this.post);
  }
}
