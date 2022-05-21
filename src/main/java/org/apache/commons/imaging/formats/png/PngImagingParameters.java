/*
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */

package org.apache.commons.imaging.formats.png;

import java.util.Collections;
import java.util.List;

import org.apache.commons.imaging.common.XmpImagingParameters;

/**
 * Png format parameters.
 * @since 1.0-alpha3
 */
public class PngImagingParameters extends XmpImagingParameters {

    public static final byte DEFAULT_BIT_DEPTH = 8;

    /**
     * Bit depth. Default value is {@literal 8}.
     */
    private byte bitDepth = DEFAULT_BIT_DEPTH;

    private boolean forceIndexedColor = false;

    private boolean forceTrueColor = false;

    private boolean predictorEnabled = false;

    /**
     * Used in write operations to indicate the Physical Scale - sCAL.
     *
     * <p>Valid values: PhysicalScale</p>
     *
     * @see org.apache.commons.imaging.formats.png.PhysicalScale
     */
    private PhysicalScale physicalScale = null;

    /**
     * <p>Only used when writing Png images.</p>
     *
     * <p>Valid values: a list of WriteTexts.</p>
     */
    private List<? extends PngText> textChunks = null;

    public byte getBitDepth() {
        return bitDepth;
    }

    public void setBitDepth(final byte bitDepth) {
        this.bitDepth = bitDepth;
    }

    public boolean isForceIndexedColor() {
        return forceIndexedColor;
    }

    public void setForceIndexedColor(final boolean forceIndexedColor) {
        this.forceIndexedColor = forceIndexedColor;
    }

    public boolean isForceTrueColor() {
        return forceTrueColor;
    }

    public void setForceTrueColor(final boolean forceTrueColor) {
        this.forceTrueColor = forceTrueColor;
    }

    public PhysicalScale getPhysicalScale() {
        return physicalScale;
    }

    public void setPhysicalScale(final PhysicalScale physicalScale) {
        this.physicalScale = physicalScale;
    }

    public List<? extends PngText> getTextChunks() {
        return textChunks != null ? Collections.unmodifiableList(textChunks) : null;
    }

    public void setTextChunks(final List<? extends PngText> textChunks) {
        this.textChunks = Collections.unmodifiableList(textChunks);
    }

    /**
     * Indicates that the PNG write operation should enable
     * the predictor.
     * @return true if the predictor is enabled; otherwise, false.
     */
    public boolean isPredictorEnabled(){
        return predictorEnabled;
    }

    /**
     * Sets the enabled status of the predictor. When performing
     * data compression on an image, a PNG predictor often results in a
     * reduced file size. Predictors are particularly effective on
     * photographic images, but may also work on graphics.
     * The specification of a predictor may result in an increased
     * processing time when writing an image, but will not affect the
     * time required to read an image.
     * @param predictorEnabled true if a predictor is enabled; otherwise, false.
     */
    public void setPredictorEnabled(final boolean predictorEnabled){
        this.predictorEnabled = predictorEnabled;
    }
}
