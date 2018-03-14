package com.mobylis.fr.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mobylis.fr.service.exception.FileServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

/**
 * @author ANDRE
 * @since 03/03/2018
 */
@Service
public class FileServiceImpl implements FileService {

    private Cloudinary cloudinary;

    private static final String PUBLIC_ID = "public_id";
    private static final String FORMAT = "format";

    public FileServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public String upload(byte[] files) {
        try {
            final Map upload = cloudinary.uploader().upload(files, ObjectUtils.emptyMap());
            final String publicId = (String) upload.get(PUBLIC_ID);
            final String format = (String) upload.get(FORMAT);
            return publicId + '.' + format;
        } catch (IOException e) {
            throw new FileServiceException("Error while uploading to cloudinary.");
        }
    }

}
