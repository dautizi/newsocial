package com.newsocial.dao;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.StringUtils;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.WriteConcern;
import com.mongodb.WriteResult;
import com.newsocial.dao.response.UserDAOResponse;
import com.newsocial.model.User;
import com.newsocial.util.AppConstants;
import com.newsocial.util.DatetimeManager;
import com.newsocial.util.DictionaryDB;

public class UserDAOImpl implements UserDAO {

    protected final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

    private MongoOperations mongoOps;
    private static final String USER_COLLECTION = "user";

    public UserDAOImpl(MongoOperations mongoOps) {
        this.mongoOps = mongoOps;
    }

    public UserDAOResponse createUser(User user) throws Exception {
        UserDAOResponse userDAOResponse = null;
        if (user != null && !StringUtils.isEmpty(user.getEmail()) 
                && !StringUtils.isEmpty(user.getUsername()) && !StringUtils.isEmpty(user.getPassword())) {

            String username = user.getUsername();
            String password = user.getPassword();
            String email = user.getEmail();
            String encryptedPassword = "";
            logger.info("New User input data: username=" + username + ", email=" + email 
                    + ", password=" + password + ", encryptedPassword=" + encryptedPassword);

            // create a new document
            BasicDBObject document = new BasicDBObject();
            document.put(DictionaryDB.USER_USERNAME, username);
            document.put(DictionaryDB.USER_EMAIL, email);
            document.put(DictionaryDB.USER_PASSWORD, password);
            document.put(DictionaryDB.USER_ENCRYPTED_PASSWORD, encryptedPassword);

            // activation status set to false the first time
            document.put(DictionaryDB.USER_ACTIVE, false);

            long now = DatetimeManager.getJodaNowInLong();
            document.put(DictionaryDB.USER_SIGNUP_DATE, now);
            document.put(DictionaryDB.USER_SIGNUP_DATE_FORMAT, DatetimeManager.getJodaDatetimeInString(now));

            // get the User collection
            DBCollection userCollection = this.mongoOps.getCollection(DictionaryDB.USER_COLLECTION);
            WriteResult writeResult = userCollection.insert(document, WriteConcern.SAFE);
            if (writeResult.getError() != null) {
                logger.error("User creation failed! " + writeResult.getError());
                userDAOResponse = new UserDAOResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), 
                        String.format(AppConstants.INSERT_ERROR_MESSAGE + ": %s", writeResult), user);
            } else {
                logger.info("User creation success! ");
                userDAOResponse = new UserDAOResponse(Response.Status.OK.getStatusCode(),
                        AppConstants.INSERT_SUCCESS_MESSAGE, user);
            }
        } else {
            userDAOResponse = new UserDAOResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
                    AppConstants.INSERT_ERROR_MESSAGE, user);
        }

        return userDAOResponse;
    }

    public UserDAOResponse updateUser(User user) {
        UserDAOResponse userDAOResponse = null;
        if (user != null) {
            String uid = user.getId();
            logger.info("Update User id: " + uid);

            // create the search query by id
            BasicDBObject updateQuery = new BasicDBObject();
            updateQuery.put(DictionaryDB.USER_ID, uid);

            // create a new document
            BasicDBObject document = buildDocumentByUser(user);

            long now = DatetimeManager.getJodaNowInLong();
            document.put(DictionaryDB.USER_LAST_UPDATE_DATE, now);
            document.put(DictionaryDB.USER_LAST_UPDATE_DATE_FORMAT, DatetimeManager.getJodaDatetimeInString(now));

            // get the User collection
            DBCollection userCollection = this.mongoOps.getCollection(DictionaryDB.USER_COLLECTION);
            WriteResult writeResult = userCollection.update(updateQuery, document);
            if (writeResult.getError() != null) {
                logger.error("User update failed! " + writeResult.getError());
                userDAOResponse = new UserDAOResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), 
                        String.format(AppConstants.UPDATE_ERROR_MESSAGE + ": %s", writeResult), user);
            } else {
                logger.info("User update success! ");
                userDAOResponse = new UserDAOResponse(Response.Status.OK.getStatusCode(),
                        AppConstants.UPDATE_SUCCESS_MESSAGE, user);
            }
        } else {
            userDAOResponse = new UserDAOResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
                    AppConstants.UPDATE_ERROR_MESSAGE, user);
        }

        return userDAOResponse;
    }

    public UserDAOResponse activateDeactivateUser(String uid, boolean activated) {
        UserDAOResponse userDAOResponse = null;
        logger.info("Update User activation status id: " + uid + " to: " + activated);

        // create the search query by id
        BasicDBObject updateQuery = new BasicDBObject();
        updateQuery.put(DictionaryDB.USER_ID, uid);

        // create a new document
        BasicDBObject document = new BasicDBObject();
        document.put(DictionaryDB.USER_ACTIVE, activated);

        long now = DatetimeManager.getJodaNowInLong();
        document.put(DictionaryDB.USER_LAST_UPDATE_DATE, now);
        document.put(DictionaryDB.USER_LAST_UPDATE_DATE_FORMAT, DatetimeManager.getJodaDatetimeInString(now));

        // get the User collection
        DBCollection userCollection = this.mongoOps.getCollection(DictionaryDB.USER_COLLECTION);
        WriteResult writeResult = userCollection.update(updateQuery, document);
        if (writeResult.getError() != null) {
            logger.error("User status update failed! " + writeResult.getError());
            userDAOResponse = new UserDAOResponse(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), 
                    String.format(AppConstants.UPDATE_ERROR_MESSAGE + ": %s", writeResult), null);
        } else {
            logger.info("User status update success! ");
            userDAOResponse = new UserDAOResponse(Response.Status.OK.getStatusCode(),
                    AppConstants.UPDATE_SUCCESS_MESSAGE, null);
        }

        return userDAOResponse;
    }

    public UserDAOResponse getUserByEmail(String email) {
        Query query = new Query(Criteria.where("email").is(email));
        User user = this.mongoOps.findOne(query, User.class, USER_COLLECTION);
        UserDAOResponse userDAOResponse = new UserDAOResponse(Response.Status.OK.getStatusCode(),
                AppConstants.INSERT_SUCCESS_MESSAGE, user);

        return userDAOResponse;
    }

    public UserDAOResponse getUserByUsername(String username) {
        Query query = new Query(Criteria.where("username").is(username));
        User user = this.mongoOps.findOne(query, User.class, USER_COLLECTION);
        UserDAOResponse userDAOResponse = new UserDAOResponse(Response.Status.OK.getStatusCode(),
                AppConstants.INSERT_SUCCESS_MESSAGE, user);

        return userDAOResponse;
    }

    public UserDAOResponse getUserById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        User user = this.mongoOps.findOne(query, User.class, USER_COLLECTION);
        UserDAOResponse userDAOResponse = new UserDAOResponse(Response.Status.OK.getStatusCode(),
                AppConstants.INSERT_SUCCESS_MESSAGE, user);
        return userDAOResponse;
    }

    private BasicDBObject buildDocumentByUser(User user) {
        BasicDBObject document = new BasicDBObject();
        if (user.getActive() != null) 
            document.put(DictionaryDB.USER_ACTIVE, user.getActive());

        if (user.getIsPrivate() != null) 
            document.put(DictionaryDB.USER_IS_PRIVATE, user.getIsPrivate());

        if (user.getBio() != null)
            document.put(DictionaryDB.USER_BIO, user.getBio());

        if (user.getBirthdate() != null) 
            document.put(DictionaryDB.USER_BIRTHDATE, user.getBirthdate());

        if (user.getBirthday() != null) 
            document.put(DictionaryDB.USER_BIRTHDAY, user.getBirthday());

        if (user.getBirthmonth() != null) 
            document.put(DictionaryDB.USER_BIRTHMONTH, user.getBirthmonth());

        if (user.getBirthyear() != null) 
            document.put(DictionaryDB.USER_BIRTHYEAR, user.getBirthyear());

        if (user.getCity() != null) 
            document.put(DictionaryDB.USER_CITY, user.getCity());

        if (user.getCountry() != null) 
            document.put(DictionaryDB.USER_COUNTRY, user.getCountry());

        if (user.getEmail() != null) 
            document.put(DictionaryDB.USER_EMAIL, user.getEmail());

        if (user.getEncryptedPassword() != null) 
            document.put(DictionaryDB.USER_ENCRYPTED_PASSWORD, user.getEncryptedPassword());

        if (user.getIdCountry() != null) 
            document.put(DictionaryDB.USER_ID_COUNTRY, user.getIdCountry());

        if (user.getName() != null) 
            document.put(DictionaryDB.USER_NAME, user.getName());

        if (user.getSurname() != null) 
            document.put(DictionaryDB.USER_SURNAME, user.getSurname());

        if (user.getNationality() != null) 
            document.put(DictionaryDB.USER_NATIONALITY, user.getNationality());

        if (user.getNotes() != null) 
            document.put(DictionaryDB.USER_NOTES, user.getNotes());

        if (user.getPassword() != null) 
            document.put(DictionaryDB.USER_PASSWORD, user.getPassword());

        if (user.getUsername() != null) 
            document.put(DictionaryDB.USER_USERNAME, user.getUsername());

        return document;
    }

}
