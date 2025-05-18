# 🏥 Medical Appointment Booking System

A **Java-based console application** that enables patients to book medical appointments, while admins manage doctors using advanced Java features like **OOP, annotations, reflection, and custom exception handling** — all without file handling to keep the focus on core Java principles.

---

## 📌 Features

- 👤 **User Types**: Abstract `User` class with two main roles: `Patient`, `Doctor`, and `Admin`
- 🗓️ **Appointment Booking**: Patients can book appointments with available doctors
- ✅ **Appointment Completion**: Mark appointments as completed, which re-enables the doctor
- 🔐 **Admin Role Security**: Role-based access using **custom annotations** and **reflection**
- ⚠️ **Robust Error Handling**: Custom exception `InvalidAppointmentException` for booking/management errors
- 💡 **No File Handling**: Focus entirely on **OOP, Java Collections, Reflection, Annotations, and Exception Handling**

---

## 🧱 Project Structure

### 🔷 Abstract Class: `User`
- Fields: `id`, `name`
- Abstract method: `void showProfile()`

### 👨‍⚕️ Class: `Doctor` (extends `User`)
- Field: `boolean available = true`
- Getter/setter & overrides `showProfile()`

### 🧑‍💼 Class: `Patient` (extends `User`)
- Overrides `showProfile()`

### 📅 Class: `Appointment`
- Fields:
  - `Patient`
  - `Doctor`
  - `String status = "Scheduled"`
- Constructor sets doctor as unavailable
- Method `completeAppointment()` sets status to `"Completed"` and re-enables the doctor
- Provides `getStatus()` and `appointmentDetails()`

### ⚠️ Custom Exception: `InvalidAppointmentException`
- Thrown if:
  - No doctors are available
  - Appointment index is invalid or already completed

### 🛡️ Custom Annotation: `@Security(role = "Admin")`
- Retention: `RUNTIME`
- Target: `TYPE`
- Used to secure admin-only actions via reflection

### 🔑 Class: `Admin` (extends `User`)
- Annotated with `@Security(role = "Admin")`
- Method: `removeDoctor(List<Doctor> doctors, String doctorId)` validated via reflection

### 🧠 Class: `AppointmentSystem`
- Fields:
  - `List<Patient> patients`
  - `List<Doctor> doctors`
  - `List<Appointment> appointments`
- Methods:
  - `registerPatient(Patient patient)`
  - `registerDoctor(Doctor doctor)`
  - `Appointment bookAppointment(Patient patient)`
  - `void completeAppointment(int index)`
  - `void showAllDoctors()`
  - `void showAllAppointments()`

### 🏁 Class: `Main`
- Methods:
  - `1. Register Patient`
  - `2. Register Doctor`
  - `3. Book Appointment`
  - `4. Show All Doctors`
  - `5. Show All Appointments`
  - `6. Complete Appointment`
  - `7. Exit`
