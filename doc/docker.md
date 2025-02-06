# Docker Cleanup Steps

Below is a summary of the steps executed, with sensitive details (like container and volume IDs) abstracted for privacy.

## 1. List All Docker Containers

**Command:**

docker ps -a

**Purpose:**  
Displays all containers (both running and stopped) to review their status.

---

## 2. Remove a Specific Docker Container

**Command:**

docker rm <container-id>

**Purpose:**  
Deletes the specified container (in this case, a MySQL container that had exited).

**Note:**  
Replace <container-id> with the actual container ID from the docker ps -a output.

---

## 3. Prune Unused Docker Volumes

**Command:**

docker volume prune

**Purpose:**  
Removes all anonymous local volumes that are not used by any container, thereby freeing up disk space.

**Process:**

- You receive a warning and are prompted for confirmation.
- After confirming (by typing 'y'), Docker deletes the unused volumes and reports the total reclaimed space.

---
