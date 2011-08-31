/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package com.cashlo.jpglib;

import java.io.ByteArrayOutputStream;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;

import org.appcelerator.titanium.TiBlob;
import org.appcelerator.titanium.TiContext;
import org.appcelerator.titanium.util.Log;
import org.appcelerator.titanium.util.TiConfig;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;

@Kroll.module(name = "Jpglib", id = "com.cashlo.jpglib")
public class JpglibModule extends KrollModule {

	// Standard Debugging variables
	private static final String LCAT = "JpglibModule";
	private static final boolean DBG = TiConfig.LOGD;

	// You can define constants with @Kroll.constant, for example:
	// @Kroll.constant public static final String EXTERNAL_NAME = value;

	public JpglibModule(TiContext tiContext) {
		super(tiContext);
	}

	@Kroll.method
	public TiBlob compress(TiBlob image) {

		BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inJustDecodeBounds = true;
		byte[] imageBytes = image.getBytes();
		BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length, opts);
		Integer imageSize = Math.max(opts.outWidth, opts.outHeight);
		if (imageSize > 600)
			opts.inSampleSize =  imageSize/600;
		opts.inJustDecodeBounds = false;
		Bitmap resized = BitmapFactory.decodeByteArray(image.getBytes(), 0,
				imageBytes.length, opts);
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		resized.compress(CompressFormat.JPEG, 70, stream);
		TiBlob blob = TiBlob.blobFromData(getTiContext(), stream.toByteArray(),
				"image/jpeg");

		return blob;
	}

}