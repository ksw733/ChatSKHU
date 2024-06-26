package com.skhu.chat.domain;

import com.skhu.common.BaseTimeEntity;
import com.skhu.oauth.domain.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@Table(name = "chat")
@NoArgsConstructor
public class Chat extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chat_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@Column
	private String question;
	
	@Column(length = 2000)
	private String answer;

	@ManyToOne
	@JoinColumn(name = "CHATROOM_ID")
	private ChatRoom chatRoom;

	@OneToMany(mappedBy = "chat", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Bookmark> bookmarks;


	@Builder
	public Chat(String question, String answer, User user, ChatRoom chatRoom) {
		this.question = question;
		this.answer = answer;
		this.user = user;
		this.chatRoom = chatRoom;
	}
}
