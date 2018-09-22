package com.upgrad.ImageHoster.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.upgrad.ImageHoster.model.Comment;
import com.upgrad.ImageHoster.model.Image;
import com.upgrad.ImageHoster.model.User;
import com.upgrad.ImageHoster.service.CommentService;
import com.upgrad.ImageHoster.service.ImageService;

@Controller
public class CommentController {

	@Autowired
	private ImageService imageService;

	@Autowired
	private CommentService commentService;

	@RequestMapping(value = "/image/{imageId}/comments/create", method = RequestMethod.POST)
	public String add(@PathVariable int imageId, @RequestParam String comment,
			HttpSession session) {
		User currUser = (User) session.getAttribute("currUser");

		// currUser is null means that the user is not logged in
		// therefore redirect the user back to the home page
		if (currUser == null) {
			return "redirect:/";
		} else {
			Image image = imageService.getByIdWithJoin(imageId);

			Comment cmt = new Comment(comment, currUser, image);
			cmt = commentService.add(cmt);

			image.getComments().add(cmt);
			imageService.update(image);
			return "redirect:/images/" + imageId;
		}
	}

}
