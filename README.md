# Quora-like Application API Specification

## Overview

This API provides functionalities for a Q&A platform where users can:
- Ask questions
- Answer questions
- Comment on answers or comments
- Like questions, answers, and comments
- Follow other users
- Organize content using topic tags

> **Note:** Every action involving a user requires the `userId` to be explicitly provided.

---

## API Endpoints

### 🧑‍💼 User Actions

#### `POST /users`
**Description:** Register a new user  
**Request Body:**
- `username` : string (required)
- `email` : string (required)  
  **Response:** `201 Created`  
  Returns the user object with user details including the `userId`.

---

#### `GET /users/{userId}`
**Description:** Get user profile by ID  
**Response:** `200 OK`  
Returns the user profile.

---

#### `PUT /users/{userId}`
**Description:** Update user profile  
**Request Body:**
- `username` : string (optional)
- `email` : string (optional)
- `bio` : string (optional)  
  **Response:** `200 OK`  
  Returns the updated user object.

---

### ❓ Question Management

#### `POST /questions`
**Description:** Post a new question  
**Request Body:**
- `userId` : UUID (required)
- `title` : string (required)
- `body` : string (required)
- `topicTags` : array of strings (optional)  
  **Response:** `201 Created`  
  Returns the question object.

---

#### `GET /questions/search`
**Description:** Search questions based on text and/or tags  
**Query Params:**
- `text` : string (optional)
- `tag` : string (optional)  
  **Response:** `200 OK`  
  Returns an array of matched questions.

---

### 💬 Answer Management

#### `POST /questions/{questionId}/answers`
**Description:** Post an answer to a question  
**Request Body:**
- `userId` : UUID (required)
- `text` : string (required)  
  **Response:** `201 Created`  
  Returns the answer object.

---

#### `PUT /answers/{answerId}`
**Description:** Edit an existing answer  
**Request Body:**
- `text` : string (required)  
  **Response:** `200 OK`  
  Returns the updated answer object.

---

### 🗨️ Comment Management

#### `POST /answers/{answerId}/comments`
**Description:** Comment on an answer  
**Request Body:**
- `userId` : UUID (required)
- `text` : string (required)  
  **Response:** `201 Created`  
  Returns the comment object.

---

#### `POST /comments/{commentId}/comments`
**Description:** Reply to a comment  
**Request Body:**
- `userId` : UUID (required)
- `text` : string (required)  
  **Response:** `201 Created`  
  Returns the comment object.

---

### 👍 Like Management

#### `POST /{type}/{id}/likes`
**Description:** Like a question, answer, or comment  
**Path Params:**
- `type` : `"questions"`, `"answers"`, or `"comments"`
- `id` : UUID  
  **Request Body:**
- `userId` : UUID (required)  
  **Response:** `201 Created`  
  Returns a success message.

---

### ➕ Follow Management

#### `POST /users/{userId}/follow/{targetUserId}`
**Description:** Follow another user  
**Path Params:**
- `userId` : UUID (follower's ID)
- `targetUserId` : UUID (user to be followed)  
  **Response:** `201 Created`  
  Returns a success message.

---

### 🏷️ Topic Management

#### `POST /topics`
**Description:** Create a new topic  
**Request Body:**
- `name` : string (required)  
  **Response:** `201 Created`  
  Returns the topic object.

---

#### `GET /topics`
**Description:** Retrieve all topics  
**Response:** `200 OK`  
Returns an array of topic objects.

---

## 🧩 Data Models

### User
- `id`: UUID
- `username`: string
- `email`: string
- `bio`: string (optional)

### Question
- `id`: UUID
- `title`: string
- `body`: string
- `topics`: array of Topic IDs
- `created_at`: timestamp
- `user_id`: UUID

### Answer
- `id`: UUID
- `question_id`: UUID
- `text`: string
- `created_at`: timestamp
- `user_id`: UUID

### Comment
- `id`: UUID
- `parent_id`: UUID (answer or comment ID)
- `text`: string
- `created_at`: timestamp
- `user_id`: UUID

### Topic
- `id`: UUID
- `name`: string

---

## ✅ Response and Error Handling

- **Success Responses:**  
  Use appropriate HTTP status codes (`200`, `201`, etc.) with data payloads.

- **Error Responses:**  
  Return standard HTTP error codes (`400`, `404`, `500`, etc.) with an informative error message.

---

