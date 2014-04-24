package com.wandrell.tabletop.rpg.pendragon.persistence.xml.background;

import org.jdom2.Document;
import org.jdom2.Element;

import com.wandrell.tabletop.rpg.conf.FileStreamerTags;
import com.wandrell.tabletop.rpg.pendragon.character.background.culture.Culture;
import com.wandrell.tabletop.rpg.pendragon.character.background.culture.CultureCharacterTemplate;
import com.wandrell.tabletop.rpg.pendragon.conf.FileLabels;
import com.wandrell.util.stream.api.xml.XMLDocumentBuilder;

public class CultureXMLDocumentBuilder implements XMLDocumentBuilder<Culture> {

    private static Element buildAttributesLimitsTemplateXMLNode(
	    final CultureCharacterTemplate holder, final Element root) {
	// TODO
	// final Iterator<NamedContrastInterval<Integer>> itrAttributes;
	// NamedInterval<Integer> interval;
	// Element node, nodeInterval, result;
	//
	// result = PersistenceFactory.getPendragonTemplateService()
	// .buildPendragonTemplateXMLNode(holder, root);
	//
	// Attributes intervals
	// itrAttributes = holder.getAttributesLimitsIterator();
	// node = new Element(FileLabels.ATTRIBUTES_LIMITS);
	// while (itrAttributes.hasNext()) {
	// interval = itrAttributes.next();
	// nodeInterval = XMLUtils.buildIntervalXMLNode(interval,
	// FileLabels.ATTRIBUTE);
	// if (nodeInterval != null) {
	// node.addContent(nodeInterval);
	// }
	// }
	// if (node.getChildren().size() > 0) {
	// result.addContent(node);
	// }

	return null;
    }

    @Override
    public Document buildDocument(final Culture holder) {
	final Document doc;
	Element node;

	// Main body and name of the culture
	node = new Element(FileLabels.CULTURE);
	node.setAttribute(FileStreamerTags.NAME, holder.getName());
	doc = new Document(node);

	// Selector files
	// TODO
	// node = XMLUtils.buildStringsDictionaryXMLTree(new Element(
	// FileLabels.SELECTORS_FILES), holder.getFilesIterator(),
	// FileLabels.FILE);
	if (node.getChildren().size() > 0) {
	    doc.getRootElement().addContent(node);
	}

	// Female template
	node = new Element(FileLabels.TEMPLATE_FEMALE);
	buildAttributesLimitsTemplateXMLNode(holder.getFemaleTemplate(), node);
	doc.getRootElement().addContent(node);

	// Male template
	node = new Element(FileLabels.TEMPLATE_MALE);
	buildAttributesLimitsTemplateXMLNode(holder.getMaleTemplate(), node);
	doc.getRootElement().addContent(node);

	// Random generation templates

	// Female template
	node = new Element(FileLabels.TEMPLATE_FEMALE_RANDOM);
	buildAttributesLimitsTemplateXMLNode(holder.getFemaleRandomTemplate(),
		node);
	if (node.getChild(FileLabels.ATTRIBUTES) == null) {
	    node.addContent(new Element(FileLabels.ATTRIBUTES));
	}
	if (node.getChild(FileLabels.PASSIONS) == null) {
	    node.addContent(new Element(FileLabels.PASSIONS));
	}
	doc.getRootElement().addContent(node);

	// Male template
	node = new Element(FileLabels.TEMPLATE_MALE_RANDOM);
	buildAttributesLimitsTemplateXMLNode(holder.getMaleRandomTemplate(),
		node);
	if (node.getChild(FileLabels.ATTRIBUTES) == null) {
	    node.addContent(new Element(FileLabels.ATTRIBUTES));
	}
	if (node.getChild(FileLabels.PASSIONS) == null) {
	    node.addContent(new Element(FileLabels.PASSIONS));
	}
	doc.getRootElement().addContent(node);

	return doc;
    }

}