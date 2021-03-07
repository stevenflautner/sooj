package io.sooj.external

import org.w3c.dom.css.CSSStyleDeclaration

const val EMPTY_STRING = ""

fun CSSStyleDeclaration.applyCss(css: Css) {
    cssText = css.cssText ?: EMPTY_STRING
    //    val parentRule: CSSRule?
    cssFloat = css.cssFloat ?: EMPTY_STRING
    alignContent = css.alignContent ?: EMPTY_STRING
    alignItems = css.alignItems ?: EMPTY_STRING
    alignSelf = css.alignSelf ?: EMPTY_STRING
    animation = css.animation ?: EMPTY_STRING
    animationDelay = css.animationDelay ?: EMPTY_STRING
    animationDirection = css.animationDirection ?: EMPTY_STRING
    animationDuration = css.animationDuration ?: EMPTY_STRING
    animationFillMode = css.animationFillMode ?: EMPTY_STRING
    animationIterationCount = css.animationIterationCount ?: EMPTY_STRING
    animationName = css.animationName ?: EMPTY_STRING
    animationPlayState = css.animationPlayState ?: EMPTY_STRING
    animationTimingFunction = css.animationTimingFunction ?: EMPTY_STRING
    backfaceVisibility = css.backfaceVisibility ?: EMPTY_STRING
    background = css.background ?: EMPTY_STRING
    backgroundAttachment = css.backgroundAttachment ?: EMPTY_STRING
    backgroundClip = css.backgroundClip ?: EMPTY_STRING
    backgroundColor = css.backgroundColor ?: EMPTY_STRING
    backgroundImage = css.backgroundImage ?: EMPTY_STRING
    backgroundOrigin = css.backgroundOrigin ?: EMPTY_STRING
    backgroundPosition = css.backgroundPosition ?: EMPTY_STRING
    backgroundRepeat = css.backgroundRepeat ?: EMPTY_STRING
    backgroundSize = css.backgroundSize ?: EMPTY_STRING
    border = css.border ?: EMPTY_STRING
    borderBottom = css.borderBottom ?: EMPTY_STRING
    borderBottomColor = css.borderBottomColor ?: EMPTY_STRING
    borderBottomLeftRadius = css.borderBottomLeftRadius ?: EMPTY_STRING
    borderBottomRightRadius = css.borderBottomRightRadius ?: EMPTY_STRING
    borderBottomStyle = css.borderBottomStyle ?: EMPTY_STRING
    borderBottomWidth = css.borderBottomWidth ?: EMPTY_STRING
    borderCollapse = css.borderCollapse ?: EMPTY_STRING
    borderColor = css.borderColor ?: EMPTY_STRING
    borderImage = css.borderImage ?: EMPTY_STRING
    borderImageOutset = css.borderImageOutset ?: EMPTY_STRING
    borderImageRepeat = css.borderImageRepeat ?: EMPTY_STRING
    borderImageSlice = css.borderImageSlice ?: EMPTY_STRING
    borderImageSource = css.borderImageSource ?: EMPTY_STRING
    borderImageWidth = css.borderImageWidth ?: EMPTY_STRING
    borderLeft = css.borderLeft ?: EMPTY_STRING
    borderLeftColor = css.borderLeftColor ?: EMPTY_STRING
    borderLeftStyle = css.borderLeftStyle ?: EMPTY_STRING
    borderLeftWidth = css.borderLeftWidth ?: EMPTY_STRING
    borderRadius = css.borderRadius ?: EMPTY_STRING
    borderRight = css.borderRight ?: EMPTY_STRING
    borderRightColor = css.borderRightColor ?: EMPTY_STRING
    borderRightStyle = css.borderRightStyle ?: EMPTY_STRING

    borderRightWidth = css.borderRightWidth ?: EMPTY_STRING
    borderSpacing = css.borderSpacing ?: EMPTY_STRING
    borderStyle = css.borderStyle ?: EMPTY_STRING
    borderTop = css.borderTop ?: EMPTY_STRING
    borderTopColor = css.borderTopColor ?: EMPTY_STRING
    borderTopLeftRadius = css.borderTopLeftRadius ?: EMPTY_STRING
    borderTopRightRadius = css.borderTopRightRadius ?: EMPTY_STRING
    borderTopStyle = css.borderTopStyle ?: EMPTY_STRING
    borderTopWidth = css.borderTopWidth ?: EMPTY_STRING
    borderWidth = css.borderWidth ?: EMPTY_STRING
    bottom = css.bottom ?: EMPTY_STRING
    boxDecorationBreak = css.boxDecorationBreak ?: EMPTY_STRING
    boxShadow = css.boxShadow ?: EMPTY_STRING
    boxSizing = css.boxSizing ?: EMPTY_STRING
    breakAfter = css.breakAfter ?: EMPTY_STRING
    breakBefore = css.breakBefore ?: EMPTY_STRING
    breakInside = css.breakInside ?: EMPTY_STRING
    captionSide = css.captionSide ?: EMPTY_STRING
    clear = css.clear ?: EMPTY_STRING
    clip = css.clip ?: EMPTY_STRING
    color = css.color ?: EMPTY_STRING
    columnCount = css.columnCount ?: EMPTY_STRING
    columnFill = css.columnFill ?: EMPTY_STRING
    columnGap = css.columnGap ?: EMPTY_STRING
    columnRule = css.columnRule ?: EMPTY_STRING
    columnRuleColor = css.columnRuleColor ?: EMPTY_STRING
    columnRuleStyle = css.columnRuleStyle ?: EMPTY_STRING
    columnRuleWidth = css.columnRuleWidth ?: EMPTY_STRING
    columnSpan = css.columnSpan ?: EMPTY_STRING
    columnWidth = css.columnWidth ?: EMPTY_STRING
    columns = css.columns ?: EMPTY_STRING
    content = css.content ?: EMPTY_STRING
    counterIncrement = css.counterIncrement ?: EMPTY_STRING
    counterReset = css.counterReset ?: EMPTY_STRING
    cursor = css.cursor ?: EMPTY_STRING
    direction = css.direction ?: EMPTY_STRING
    display = css.display ?: EMPTY_STRING
    emptyCells = css.emptyCells ?: EMPTY_STRING
    filter = css.filter ?: EMPTY_STRING
    flex = css.flex ?: EMPTY_STRING
    flexBasis = css.flexBasis ?: EMPTY_STRING
    flexDirection = css.flexDirection ?: EMPTY_STRING
    flexFlow = css.flexFlow ?: EMPTY_STRING
    flexGrow = css.flexGrow ?: EMPTY_STRING
    flexShrink = css.flexShrink ?: EMPTY_STRING
    flexWrap = css.flexWrap ?: EMPTY_STRING
    font = css.font ?: EMPTY_STRING
    fontFamily = css.fontFamily ?: EMPTY_STRING
    fontFeatureSettings = css.fontFeatureSettings ?: EMPTY_STRING
    fontKerning = css.fontKerning ?: EMPTY_STRING
    fontLanguageOverride = css.fontLanguageOverride ?: EMPTY_STRING
    fontSize = css.fontSize ?: EMPTY_STRING
    fontSizeAdjust = css.fontSizeAdjust ?: EMPTY_STRING
    fontStretch = css.fontStretch ?: EMPTY_STRING
    fontStyle = css.fontStyle ?: EMPTY_STRING
    fontSynthesis = css.fontSynthesis ?: EMPTY_STRING
    fontVariant = css.fontVariant ?: EMPTY_STRING
    fontVariantAlternates = css.fontVariantAlternates ?: EMPTY_STRING
    fontVariantCaps = css.fontVariantCaps ?: EMPTY_STRING
    fontVariantEastAsian = css.fontVariantEastAsian ?: EMPTY_STRING
    fontVariantLigatures = css.fontVariantLigatures ?: EMPTY_STRING
    fontVariantNumeric = css.fontVariantNumeric ?: EMPTY_STRING
    fontVariantPosition = css.fontVariantPosition ?: EMPTY_STRING
    fontWeight = css.fontWeight ?: EMPTY_STRING
    hangingPunctuation = css.hangingPunctuation ?: EMPTY_STRING
    height = css.height ?: EMPTY_STRING
    hyphens = css.hyphens ?: EMPTY_STRING
    imageOrientation = css.imageOrientation ?: EMPTY_STRING
    imageRendering = css.imageRendering ?: EMPTY_STRING
    imageResolution = css.imageResolution ?: EMPTY_STRING
    imeMode = css.imeMode ?: EMPTY_STRING
    justifyContent = css.justifyContent ?: EMPTY_STRING
    left = css.left ?: EMPTY_STRING
    letterSpacing = css.letterSpacing ?: EMPTY_STRING
    lineBreak = css.lineBreak ?: EMPTY_STRING
    lineHeight = css.lineHeight ?: EMPTY_STRING
    listStyle = css.listStyle ?: EMPTY_STRING
    listStyleImage = css.listStyleImage ?: EMPTY_STRING
    listStylePosition = css.listStylePosition ?: EMPTY_STRING
    listStyleType = css.listStyleType ?: EMPTY_STRING
    margin = css.margin ?: EMPTY_STRING
    marginBottom = css.marginBottom ?: EMPTY_STRING
    marginLeft = css.marginLeft ?: EMPTY_STRING
    marginRight = css.marginRight ?: EMPTY_STRING
    marginTop = css.marginTop ?: EMPTY_STRING
    mark = css.mark ?: EMPTY_STRING
    markAfter = css.markAfter ?: EMPTY_STRING
    markBefore = css.markAfter ?: EMPTY_STRING
    marks = css.marks ?: EMPTY_STRING
    marqueeDirection = css.marqueeDirection ?: EMPTY_STRING
    marqueePlayCount = css.marqueePlayCount ?: EMPTY_STRING
    marqueeSpeed = css.marqueeSpeed ?: EMPTY_STRING
    marqueeStyle = css.marqueeStyle ?: EMPTY_STRING
    mask = css.mask ?: EMPTY_STRING
    maskType = css.maskType ?: EMPTY_STRING
    maxHeight = css.maxHeight ?: EMPTY_STRING
    maxWidth = css.maxWidth ?: EMPTY_STRING
    minHeight = css.minHeight ?: EMPTY_STRING
    minWidth = css.minWidth ?: EMPTY_STRING
    navDown = css.navDown ?: EMPTY_STRING
    navIndex = css.navIndex ?: EMPTY_STRING
    navLeft = css.navLeft ?: EMPTY_STRING
    navRight = css.navRight ?: EMPTY_STRING
    navUp = css.navUp ?: EMPTY_STRING
    objectFit = css.objectFit ?: EMPTY_STRING
    objectPosition = css.objectPosition ?: EMPTY_STRING
    opacity = css.opacity ?: EMPTY_STRING
    order = css.order ?: EMPTY_STRING
    orphans = css.orphans ?: EMPTY_STRING
    outline = css.outline ?: EMPTY_STRING
    outlineColor = css.outlineColor ?: EMPTY_STRING
    outlineOffset = css.outlineOffset ?: EMPTY_STRING
    outlineStyle = css.outlineStyle ?: EMPTY_STRING
    outlineWidth = css.outlineWidth ?: EMPTY_STRING
    overflowWrap = css.overflowWrap ?: EMPTY_STRING
    overflowX = css.overflowX ?: EMPTY_STRING
    overflowY = css.overflowY ?: EMPTY_STRING
    padding = css.padding ?: EMPTY_STRING
    paddingBottom = css.paddingBottom ?: EMPTY_STRING
    paddingLeft = css.paddingLeft ?: EMPTY_STRING
    paddingRight = css.paddingRight ?: EMPTY_STRING
    paddingTop = css.paddingTop ?: EMPTY_STRING
    pageBreakAfter = css.pageBreakAfter ?: EMPTY_STRING
    pageBreakBefore = css.pageBreakBefore ?: EMPTY_STRING
    pageBreakInside = css.pageBreakInside ?: EMPTY_STRING
    perspective = css.perspective ?: EMPTY_STRING
    perspectiveOrigin = css.perspectiveOrigin ?: EMPTY_STRING
    phonemes = css.phonemes ?: EMPTY_STRING
    position = css.position ?: EMPTY_STRING
    quotes = css.quotes ?: EMPTY_STRING
    resize = css.resize ?: EMPTY_STRING
    rest = css.rest ?: EMPTY_STRING
    restAfter = css.restAfter ?: EMPTY_STRING
    restBefore = css.restBefore ?: EMPTY_STRING
    right = css.right ?: EMPTY_STRING
    tabSize = css.tabSize ?: EMPTY_STRING
    tableLayout = css.tableLayout ?: EMPTY_STRING
    textAlign = css.textAlign ?: EMPTY_STRING
    textAlignLast = css.textAlignLast ?: EMPTY_STRING
    textCombineUpright = css.textCombineUpright ?: EMPTY_STRING
    textDecoration = css.textDecoration ?: EMPTY_STRING
    textDecorationColor = css.textDecorationColor ?: EMPTY_STRING
    textDecorationLine = css.textDecorationLine ?: EMPTY_STRING
    textDecorationStyle = css.textDecorationStyle ?: EMPTY_STRING
    textIndent = css.textIndent ?: EMPTY_STRING
    textJustify = css.textJustify ?: EMPTY_STRING
    textOrientation = css.textOrientation ?: EMPTY_STRING
    textOverflow = css.textOverflow ?: EMPTY_STRING
    textShadow = css.textShadow ?: EMPTY_STRING
    textTransform = css.textTransform ?: EMPTY_STRING
    textUnderlinePosition = css.textUnderlinePosition ?: EMPTY_STRING
    top = css.top ?: EMPTY_STRING
    transform = css.transform ?: EMPTY_STRING
    transformOrigin = css.transformOrigin ?: EMPTY_STRING
    transformStyle = css.transformStyle ?: EMPTY_STRING
    transition = css.transition ?: EMPTY_STRING
    transitionDelay = css.transitionDelay ?: EMPTY_STRING
    transitionDuration = css.transitionDuration ?: EMPTY_STRING
    transitionProperty = css.transitionProperty ?: EMPTY_STRING
    transitionTimingFunction = css.transitionTimingFunction ?: EMPTY_STRING
    unicodeBidi = css.unicodeBidi ?: EMPTY_STRING
    verticalAlign = css.verticalAlign ?: EMPTY_STRING
    visibility = css.visibility ?: EMPTY_STRING
    voiceBalance = css.voiceBalance ?: EMPTY_STRING
    voiceDuration = css.voiceDuration ?: EMPTY_STRING
    voicePitch = css.voicePitch ?: EMPTY_STRING
    voicePitchRange = css.voicePitchRange ?: EMPTY_STRING
    voiceRate = css.voiceRate ?: EMPTY_STRING
    voiceStress = css.voiceStress ?: EMPTY_STRING
    voiceVolume = css.voiceVolume ?: EMPTY_STRING
    whiteSpace = css.whiteSpace ?: EMPTY_STRING
    widows = css.widows ?: EMPTY_STRING
    width = css.width ?: EMPTY_STRING
    wordBreak = css.wordBreak ?: EMPTY_STRING
    wordSpacing = css.wordSpacing ?: EMPTY_STRING
    wordWrap = css.wordWrap ?: EMPTY_STRING
    writingMode = css.writingMode ?: EMPTY_STRING
    zIndex = css.zIndex ?: EMPTY_STRING
    _dashed_attribute = css._dashed_attribute ?: EMPTY_STRING
    _camel_cased_attribute = css._camel_cased_attribute ?: EMPTY_STRING
    _webkit_cased_attribute = css._webkit_cased_attribute ?: EMPTY_STRING
}