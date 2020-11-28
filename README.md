### To Import the database, run this command:
	`mysql -uroot -p<vaccine.sql`

# Vaccine

CLINICAL VACCINE TRIAL

1) HOME PAGE(/)

* Navbar: Organization, Vaccine, About Us				Search, Login, Sign up.
* Body: Results of vaccine trial --> Onclick leads to the Vaccine's details, Logos of Organization.
* Footer: Contact Us, help, articles etc..

2) Login(/login)

* Login form.
* We have different tabs for organization and patient login.

3) Organization(/org) || (/org/:username)

* Navbar: Organization, Vaccine, Logout, About Us			Search, Edit Profile.
* Every organization can edit its profile.
* They have Start-new-Trial button.
* The organization can select the patients for trail, based on their symptoms.
* Organization contains information about the vaccine, its working on along with its report.
* The organization can also add and remove vaccine.

4) Patients(/patient) || (/patient/:username)

* Navbar: Organization, Vaccine, About Us			Search, Enroll(/enroll) button should be disabled if already enrolled, Medical Remarks(we have this in DB), EditProfile, Logout. 
* They can edit their profile.
* They can enroll in test.
* they can see their test result.

## Routes

* /login: 
* /register: 

* /org: 
* /org/profile: 
* /org/profile/edit: 
* /org/delete:
* /org/vaccine:
* /org/vaccine/add:
* /org/vaccine/delete:
* /org/vaccine/edit:
* /org/trials:
* /org/newtrial:

* /patient: 
* /patient/profile: 
* /patient/profile/edit: 
* /patient/delete:
* /patient/results:
* /patient/enroll: 

* /forgotpassword
* /logout
* /about

## Route Description

/login: 
* accepts username, password, type(org/patient)
* does authentication 
* returns success or failure 
* returns to homepage else /login

/register: 
* accepts info, type (org/patient)
* does registration, checks if user is already registered or not
* returns success or failure
* returns to /login else /register with alert msg

/org: 
* accepts: NIL
* does: list of all organizations which are registered
* returns: list of all organizations which are registered
* returns to: ListOrg

/org/profile: 
* accepts: NIL
* does: displays profile details
* returns: profile details
* returns to: profileComponent

/org/profile/edit: 
* accepts: form with user details
* does: changes user profile
* returns: success or failure
* returns to: EditProfileCoomponent

/org/delete:
* accepts: orgId
* does: checks password to delete and deletes the org
* returns: 
* returns to: 

/org/vaccine:
* accepts:
* does: 
* returns: 
* returns to:

/org/vaccine/add:
* accepts:
* does: 
* returns: 
* returns to:

/org/vaccine/delete:
* accepts:
* does: 
* returns: 
* returns to:

/org/vaccine/edit:
* accepts:
* does: 
* returns: 
* returns to:

/org/trials:
* accepts:
* does: 
* returns: 
* returns to:

/org/newtrial:
* accepts:
* does: 
* returns: 
* returns to:


/patient: 
* accepts:
* does: 
* returns: 
* returns to:

/patient/profile: 
* accepts:
* does: 
* returns: 
* returns to:

/patient/profile/edit: 
* accepts:
* does: 
* returns: 
* returns to:

/patient/delete:
* accepts:
* does: 
* returns: 
* returns to:

/patient/results:
* accepts:
* does: 
* returns: 
* returns to:

/patient/enroll: 
* accepts:
* does: 
* returns: 
* returns to:


/forgotpassword
* accepts:
* does: 
* returns: 
* returns to:

/logout
* accepts:
* does: 
* returns: 
* returns to:

/about
* accepts:
* does: 
* returns: 
* returns to:


## Routes

1) '/'- this is the route used for Index component.

2) '/signin'- this is the route used for signin component.

3) '/register/org - this route is used to register the organization.

4) '/register/patient - this route is used to register the patient.

5) '/about' - this route is used for about component.

6) '/home/org' - this route is used to display organization's home component.

7) '/home/patient' - this route is used to display patient's home component.

8) '/edit/profile/org' - this route is used to update the organization details.

9) '/edit/profile/patient' - this route is used to update patients detalis.

10) '/delte/patient' - this route is used to deactivate patient's account.

11) '/delete/org' - this route is used to deactivate organization's account.

12) '/report/patient' - this route is used to display the patient's report.

13) 'org/vacc' - this route is used to display list of vaccines related to specific organization.

14) '/org/vacc/edit' - this route is used to update the vaccine related to specific organization.

15) '/org/vacc/add' - this route is used to add the vaccine related to specific organization.

16) '/vaccines' - this route is used to display all the vaccines.

17) '/partners' - this route is used to display all the organizations.

18) '/start/trial' - this route is used to start new vaccine trial.

19) '/end/trial/' - this route is used to end the trial. 