# Task Manager + Notes support


### Project Requirements
1. Ability to add new tasks
   1.1 Task has status(completed/Incomplete)
   1.2 By default due date = today + 7 days, can be specified by the user

2.  Ability to change tasks
    2.1 Modify the due date, Completed/Incomplete status.
    2.2 Delete any task

3.  Ability to add notes to tasks
    3.1 View all notes within a task
    3.2 Add new note to a particular task
    3.3 Delete notes for a particular task

-------------------------------------------------------------------------------

API endpoints

GET     /tasks                      -> Get all tasks
GET     /tasks/{id}                 -> Get a task by id
DELETE  /tasks/{id}                 -> Delete the task for mentioned id
PATCH   /tasks/{id}                 -> Update details of a task
POST    /tasks                      -> create a new task

GET     /tasks/{id}/notes           -> Show all notes of a task
POST    /tasks/{id}/notes           -> Add a note to a task
DELETE  /tasks/{id}/notes/{nid}     -> Deletes the note from task for provide id


-------------------------------------------------------------------------------

Database Entities

1.  tasks
    - id        : int, primary_key
    - name      : String
    - due_date  : Date
    - status    : boolean


2. notes
    - id        : int, primary_key
    - body      : String
    - task_id   : foreign_key


